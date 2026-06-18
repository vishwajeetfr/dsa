class Solution {
    public double angleClock(int hour, int minutes) {
        double remHour = hour%12;
        double hourDeg = remHour*30 + minutes*0.5;
        double minDeg = minutes*6;

        double sol = Math.abs(minDeg-hourDeg);

        return Math.min(sol, 360-sol);
    }
}

// min hand
// 1hr = 360 deg
// 1hr = 60 min
// 1min = 6 deg

// hour hand
// 3 hrs = 90 deg
// 1 hrs = 30 deg
// 60 min = 30 deg
// 1 min = 0.5 deg
