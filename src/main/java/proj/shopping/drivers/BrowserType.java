package proj.shopping.drivers;

public enum BrowserType {
    CHROME,
    EDGE;

    public AbstractDriverFactory getDriverFactory() {
        switch (this) {
            case CHROME:
                return new Chrome();
                case EDGE:
                return new Edge();
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + this);
        }
    }
}
