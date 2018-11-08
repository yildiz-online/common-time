# Yildiz-Engine common-time

This is the official repository of The Common Time library, part of the Yildiz-Engine project.
The common time library is a set of utility and helper classes to handle time and dates.

## Features

* Timer.
* ...

## Requirements

To build this module, you will need the latest java JDK and Maven.

## Coding Style and other information

Project website:
http://www.yildiz-games.be

Issue tracker:
https://yildiz.atlassian.net/browse/YCT

Wiki:
https://yildiz.atlassian.net/wiki

Quality report:
https://sonarcloud.io/dashboard/index/be.yildiz-games:common-time

## License

All source code files are licensed under the permissive MIT license
(http://opensource.org/licenses/MIT) unless marked differently in a particular folder/file.

## Build instructions

Go to your root directory, where you POM file is located.

Then invoke maven

	mvn clean install

This will compile the source code, then run the unit tests, and finally build a jar file.

## Usage

In your maven project, add the dependency

```xml
<dependency>
    <groupId>be.yildiz-games</groupId>
    <artifactId>common-time</artifactId>
    <version>${project.version}</version>
</dependency>
```

## Contact
Owner of this repository: Grégory Van den Borre
