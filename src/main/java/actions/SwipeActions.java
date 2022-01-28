package actions;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import org.openqa.selenium.Point;

public class SwipeActions {

    public static void horizontalRightSwipe(ILabel lblAllInsideScrollView) {
        int height = lblAllInsideScrollView.getElement().getSize().height;
        int width = lblAllInsideScrollView.getElement().getSize().width;
        AqualityServices.getTouchActions().swipe(new Point((int) (width / 1.5), height / 2),
                new Point(0, height / 2));
    }

    public static void verticalDownSwipe(ILabel lblAllInsideScrollView) {
        int height = lblAllInsideScrollView.getElement().getSize().height;
        int width = lblAllInsideScrollView.getElement().getSize().width;
        AqualityServices.getTouchActions().swipe(
                new Point(width / 2, (int) (height / 1.5)), new Point(width / 2, height));
    }

    public static void verticalUpSwipe(ILabel lblAllInsideScrollView) {
        int height = lblAllInsideScrollView.getElement().getSize().height;
        int width = lblAllInsideScrollView.getElement().getSize().width;
        AqualityServices.getTouchActions().swipe(new Point(width / 2, height),
                new Point(width / 2, 0));
    }
}
