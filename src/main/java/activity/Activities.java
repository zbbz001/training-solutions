package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {

    private List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public List<Report> distancesByTypes() {
        List<Report> reportList = initReportList();

        for (Activity activity : activities) {
            addToReport(activity, reportList);
        }

        System.out.println(reportList.toString());
        return reportList;
    }

    public int numberOfTrackActivities() {
        int num = 0;
        for (Activity activity : activities) {
            if (activity.getType().isTrackActivity()) {
                num++;
            }
        }
        return num;
    }

    public int numberOfWithoutTrackActivities() {
        int num = 0;
        for (Activity activity : activities) {
            if (!activity.getType().isTrackActivity()) {
                num++;
            }
        }
        return num;
    }

    private List<Report> initReportList() {
        List<Report> reportList = new ArrayList<>();

        for (ActivityType activityType : ActivityType.values()) {
            reportList.add(new Report(activityType, 0));
        }

        return reportList;
    }

    private void addToReport(Activity activity, List<Report> reportList) {
        for (Report report : reportList) {
            if (report.getActivityType().equals(activity.getType())) {
                report.addDistance(activity.getDistance());
            }
        }
    }
}
