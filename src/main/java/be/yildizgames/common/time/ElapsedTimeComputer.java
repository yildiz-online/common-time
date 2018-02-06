/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2018 Grégory Van den Borre
 *
 *  More infos available: https://www.yildiz-games.be
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without
 *  limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 *  of the Software, and to permit persons to whom the Software is furnished to do so,
 *  subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial
 *  portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 *  OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  SOFTWARE.
 *
 */

package be.yildizgames.common.time;

import java.io.Serializable;
import java.time.Duration;

/**
 * Check if a given time is elapsed.
 *
 * @author Grégory Van Den Borre
 */
public final class ElapsedTimeComputer implements Serializable {

    /***/
    private static final long serialVersionUID = -8851199529330811505L;
    /**
     * Total time to wait.
     */
    private final long timeToWait;
    /**
     * last checked time.
     */
    private long lastTime;
    /**
     * Current elapsed time.
     */
    private long elapsedTime;

    /**
     * Constructor initialize the last action time with the current time.
     *
     * @param deltaTime Counter to wait between the last check and the current time,
     *                  in milliseconds.
     */
    public ElapsedTimeComputer(final long deltaTime) {
        super();
        this.timeToWait = deltaTime;
        this.lastTime = System.currentTimeMillis();
    }

    /**
     * Constructor initialize the last action time with the current time.
     *
     * @param deltaTime Counter to wait between the last check and the current time.
     */
    public ElapsedTimeComputer(final Duration deltaTime) {
        this(deltaTime.toMillis());
    }

    /**
     * Compute the completion ratio.
     *
     * @return The ration, between 0 and 1(completed).
     */
    public float getCompletion() {
        return (float) this.elapsedTime / (float) this.timeToWait;
    }

    /**
     * If the time initialized by the constructor is elapsed, the counter is
     * reset and the method return true.
     *
     * @return True if more time than the counter has passed since the last
     * reinitialisation.
     */
    public boolean isTimeElapsed() {
        long current = System.currentTimeMillis();
        this.elapsedTime = current - this.lastTime;
        if (this.elapsedTime > this.timeToWait) {
            this.lastTime = current;
            return true;
        }
        return false;
    }

    /**
     * Reset the counter.
     */
    public void reset() {
        this.lastTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return elapsedTime;
    }
}
