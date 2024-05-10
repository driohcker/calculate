public interface ThemeFactory {
    public static Theme getTheme(String themeName) {
        switch (themeName) {
            case "light":
                return new LightTheme();

            case "dark":
                return new DarkTheme();

            default:
                throw new IllegalArgumentException("Unknown theme name");
        }

    }
}
