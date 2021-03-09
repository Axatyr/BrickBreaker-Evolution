package view.utilities;

public enum PersonalImages {


    /**
     * Path for Play Image.
     */
    PLAY_IMG("/Images/MainMenuImg/BtnPlay.png"),

    /**
     * Path for Settings Image.
     */
    SETTINGS_IMG("/Images/MainMenuImg/Settings.png"),

    /**
     * Path for Tutorial Image.
     */
    TUTORIAL_IMG("/Images/MainMenuImg/Credit-card.png"),

    /**
     * Path for Ranking Image.
     */
    RANKING_IMG("/Images/MainMenuImg/Video.png");

    private String path;

    PersonalImages(final String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
