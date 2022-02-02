package actions;

import aquality.appium.mobile.actions.ITouchActions;
import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import org.openqa.selenium.Point;

public class TouchActions {

    private static final double MULTIPLIER_OF_WIDTH = 1.5;
    private static final int MULTIPLIER_OF_HEIGHT = 2;

    public static void swipe(ILabel lblAllInsideScrollView, SwipeDirection direction) {
        ITouchActions touchActions = AqualityServices.getTouchActions();
        int height = lblAllInsideScrollView.getElement().getSize().height;
        int width = lblAllInsideScrollView.getElement().getSize().width;
            switch (direction) {
                case DOWN:
                    touchActions.swipe(new Point(width / MULTIPLIER_OF_HEIGHT, (int) (height / MULTIPLIER_OF_WIDTH)),
                            new Point(width / MULTIPLIER_OF_HEIGHT, height));
                    break;
                case UP:
                    touchActions.swipe(new Point(width / MULTIPLIER_OF_HEIGHT, height),
                            new Point(width / MULTIPLIER_OF_HEIGHT, 0));
                    break;
                case LEFT:
                    touchActions.swipe(new Point((int) (width / MULTIPLIER_OF_WIDTH), height / MULTIPLIER_OF_HEIGHT),
                            new Point(0, height / MULTIPLIER_OF_HEIGHT));
                    break;
                case RIGHT:
                    touchActions.swipe(new Point(width/10, height / MULTIPLIER_OF_HEIGHT),
                            new Point(width, height / MULTIPLIER_OF_HEIGHT));
                    break;
                default:
                    throw new IllegalArgumentException(
                            String.format("'%s' direction does not exist", direction.toString()));
            }
        }
}
