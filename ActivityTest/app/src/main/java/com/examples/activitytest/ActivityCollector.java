package com.examples.activitytest;

import android.app.Activity;

import java.util.ArrayList;

public class ActivityCollector {

    public static ArrayList<Activity> activityList = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activityList.add(activity);

    }

    public static void removeActivity(Activity activity) {
        activityList.remove(activity);

    }

    public static void finishAll() {
        for (Activity activity : activityList) {
            if (!activity.isFinishing()) {
                activity.finish();

            }
        }
        activityList.clear();

    }


}
