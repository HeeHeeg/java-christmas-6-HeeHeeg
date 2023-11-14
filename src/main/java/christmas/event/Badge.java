package christmas.event;

public enum Badge {
    STAR("별"), TREE("트리"), SANTA("산타"), NONE("없음");

    private final String displayName;

    Badge(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
