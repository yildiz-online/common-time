/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2019 Grégory Van den Borre
 *
 *  More infos available: https://engine.yildiz-games.be
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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for ElapsedTimeComputer.
 *
 * @author Grégory Van den Borre
 */
public class ElapsedTimeComputerTest {

    /**
     * Time to use.
     */
    private static final long TOTAL = 2000L;

    /**
     * Test if <li>elapsed time is correct.</li> <li>isTimeElapsed return
     * value.</li>
     *
     * @throws InterruptedException From Thread class.
     */
    @Test
    public void testIsTimeElapsed() throws InterruptedException {
        final int testTime = 500;
        final int error = 50;
        ElapsedTimeComputer c = new ElapsedTimeComputer(ElapsedTimeComputerTest.TOTAL);
        Thread.sleep(testTime);
        assertFalse(c.isTimeElapsed());
        assertTrue((c.getElapsedTime() >= testTime) && (c.getElapsedTime() <= testTime + error));
        Thread.sleep(ElapsedTimeComputerTest.TOTAL);
        assertTrue(c.isTimeElapsed());
        Thread.sleep(testTime);
        assertFalse(c.isTimeElapsed());
        assertTrue((c.getElapsedTime() >= testTime) && (c.getElapsedTime() <= testTime + error));
        Thread.sleep(ElapsedTimeComputerTest.TOTAL);
        assertTrue(c.isTimeElapsed());
    }

}
