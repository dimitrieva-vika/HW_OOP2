package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void shouldCreateRadioWithDefault10Stations() {
        Radio radio = new Radio();
        Assertions.assertEquals(10, radio.getStationCount());
    }

    @Test
    public void shouldCreateRadioWithCustomStationCount() {
        Radio radio = new Radio(30);
        Assertions.assertEquals(30, radio.getStationCount());
    }

    @Test
    public void shouldCreateRadioWithInvalidStationCountUseDefault() {
        Radio radio = new Radio(0);
        Assertions.assertEquals(10, radio.getStationCount());
    }

    @Test
    public void shouldSetValidStationWithCustomCount() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(25);
        Assertions.assertEquals(25, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationAboveMax() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(30);
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationBelowZero() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(-1);
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldNextStationFromMaxToZero() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(29);
        radio.nextStation();
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldNextStationFromMiddle() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(15);
        radio.nextStation();
        Assertions.assertEquals(16, radio.getCurrentStation());
    }

    @Test
    public void shouldPrevStationFromZeroToMax() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(0);
        radio.prevStation();
        Assertions.assertEquals(29, radio.getCurrentStation());
    }

    @Test
    public void shouldPrevStationFromMiddle() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(15);
        radio.prevStation();
        Assertions.assertEquals(14, radio.getCurrentStation());
    }

    @Test
    public void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        Assertions.assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseAbove100() {
        Radio radio = new Radio();
        for (int i = 0; i < 101; i++) {
            radio.increaseVolume();
        }
        Assertions.assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        radio.decreaseVolume();
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotDecreaseBelowZero() {
        Radio radio = new Radio();
        radio.decreaseVolume();
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldWorkWithMinStationCount() {
        Radio radio = new Radio(1);
        radio.setCurrentStation(0);
        Assertions.assertEquals(0, radio.getCurrentStation());
        radio.nextStation();
        Assertions.assertEquals(0, radio.getCurrentStation());
        radio.prevStation();
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldWorkWithLargeStationCount() {
        Radio radio = new Radio(100);
        radio.setCurrentStation(99);
        Assertions.assertEquals(99, radio.getCurrentStation());
        radio.nextStation();
        Assertions.assertEquals(0, radio.getCurrentStation());
    }
}