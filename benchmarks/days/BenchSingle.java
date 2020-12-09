package days;

import days.day1.Day1;
import days.day2.Day2;
import days.day3.Day3;
import days.day4.Day4;
import days.day5.Day5;
import days.day6.Day6;
import days.day7.Day7;
import days.day8.Day8;
import days.day9.Day9;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import riddarvid.aoc.days.Day;

import java.util.InputMismatchException;
import java.util.concurrent.TimeUnit;

public class BenchSingle {
    private final static int DAY = 9;

    @Benchmark
    @BenchmarkMode({Mode.AverageTime})
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void setup(Day1State state, Blackhole blackhole) {
        state.dayFresh.setup();
        blackhole.consume(state.dayFresh);
    }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime})
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void part1(Day1State state, Blackhole blackhole) {
        blackhole.consume(state.daySetupDone.part1());
    }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime})
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void part2(Day1State state, Blackhole blackhole) {
        blackhole.consume(state.dayPart1Done.part2());
    }

    @State(Scope.Thread)
    public static class Day1State {
        public Day dayFresh;
        public Day daySetupDone;
        public Day dayPart1Done;

        public Day1State() {
            switch (DAY) {
                case 1 -> {
                    dayFresh = new Day1();
                    daySetupDone = new Day1();
                    dayPart1Done = new Day1();
                }
                case 2 -> {
                    dayFresh = new Day2();
                    daySetupDone = new Day2();
                    dayPart1Done = new Day2();
                }
                case 3 -> {
                    dayFresh = new Day3();
                    daySetupDone = new Day3();
                    dayPart1Done = new Day3();
                }
                case 4 -> {
                    dayFresh = new Day4();
                    daySetupDone = new Day4();
                    dayPart1Done = new Day4();
                }
                case 5 -> {
                    dayFresh = new Day5();
                    daySetupDone = new Day5();
                    dayPart1Done = new Day5();
                }
                case 6 -> {
                    dayFresh = new Day6();
                    daySetupDone = new Day6();
                    dayPart1Done = new Day6();
                }
                case 7 -> {
                    dayFresh = new Day7();
                    daySetupDone = new Day7();
                    dayPart1Done = new Day7();
                }
                case 8 -> {
                    dayFresh = new Day8();
                    daySetupDone = new Day8();
                    dayPart1Done = new Day8();
                }
                case 9 -> {
                    dayFresh = new Day9();
                    daySetupDone = new Day9();
                    dayPart1Done = new Day9();
                }
                default -> throw new InputMismatchException("No such day");
            }
            daySetupDone.setup();
            dayPart1Done.setup();
            dayPart1Done.part1();
        }
    }
}