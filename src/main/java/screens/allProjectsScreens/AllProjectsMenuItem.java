package screens.allProjectsScreens;

import lombok.Getter;

@Getter
public enum AllProjectsMenuItem {

    MAGIC("MAGIC"),
    POPULAR("POPULAR"),
    NEWEST("NEWEST"),
    ENDING_SOON("ENDING SOON");

    private final String name;

    AllProjectsMenuItem(String name) {
        this.name = name;
    }
}
