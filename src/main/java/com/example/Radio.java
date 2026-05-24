package com.example;

public class Radio {
    private int currentStation;
    private int currentVolume;
    private int stationCount;

    public Radio() {
        this.stationCount = 10;
    }

    public Radio(int stationCount) {
        if (stationCount > 0) {
            this.stationCount = stationCount;
        } else {
            this.stationCount = 10;
        }
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getStationCount() {
        return stationCount;
    }

    public void setCurrentStation(int station) {
        if (station >= 0 && station < stationCount) {
            currentStation = station;
        }
    }

    public void nextStation() {
        if (currentStation == stationCount - 1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    public void prevStation() {
        if (currentStation == 0) {
            currentStation = stationCount - 1;
        } else {
            currentStation--;
        }
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}