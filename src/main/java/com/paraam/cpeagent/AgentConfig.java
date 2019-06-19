package com.paraam.cpeagent;

/**
 * Structure to hold configuration information.
 */
public class AgentConfig {
    private String ipAddress;
    private String acsUrl;
    private String simulatorLocation;
    private int connectionRequestPort;
    private String connectionRequestPath;
    private int periodicInformInterval;
    private String authUserName;
    private String authPassword;
    private String authType;
    private String userAgent;
    private String xmlFormat;
    private String serialNumberFmt = "%08d";
    private int serialNumber = 0;

    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setIpAddress(final String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getAcsUrl() {
        return this.acsUrl;
    }

    public void setAcsUrl(final String acsUrl) {
        this.acsUrl = acsUrl;
    }

    public String getSimulatorLocation() {
        return this.simulatorLocation;
    }

    public void setSimulatorLocation(final String simulator) {
        this.simulatorLocation = simulator;
    }

    public int getConnectionRequestPort() {
        return this.connectionRequestPort;
    }

    public void setConnectionRequestPort(final int connectionRequestPort) {
        this.connectionRequestPort = connectionRequestPort;
    }

    public String getConnectionRequestPath() {
        return this.connectionRequestPath;
    }

    public void setConnectionRequestPath(final String connectionRequestPath) {
        this.connectionRequestPath = connectionRequestPath;
    }

    public int getPeriodicInformInterval() {
        return this.periodicInformInterval;
    }

    public void setPeriodicInformInterval(final int periodicInformInterval) {
        this.periodicInformInterval = periodicInformInterval;
    }

    public String getAuthUserName() {
        return this.authUserName;
    }

    public void setAuthUserName(final String authUserName) {
        this.authUserName = authUserName;
    }

    public String getAuthPassword() {
        return this.authPassword;
    }

    public void setAuthPassword(final String authPassword) {
        this.authPassword = authPassword;
    }

    public String getAuthType() {
        return this.authType;
    }

    public void setAuthType(final String authType) {
        this.authType = authType;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getXmlFormat() {
        return this.xmlFormat;
    }

    public void setXmlFormat(String xmlFormat) {
        this.xmlFormat = xmlFormat;
    }

    public String getSerialNumberFmt() {
        return this.serialNumberFmt;
    }

    public void setSerialNumberFmt(String serialNumberFmt) {
        this.serialNumberFmt = serialNumberFmt;
    }

    public int getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "AgentConfig{" +
                "ipAddress='" + ipAddress + '\'' +
                ", acsUrl='" + acsUrl + '\'' +
                ", simulatorLocation='" + simulatorLocation + '\'' +
                ", connectionRequestPort=" + connectionRequestPort +
                ", connectionRequestPath='" + connectionRequestPath + '\'' +
                ", periodicInformInterval=" + periodicInformInterval +
                ", authUserName='" + authUserName + '\'' +
                ", authPassword='" + authPassword + '\'' +
                ", authType='" + authType + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", xmlFormat='" + xmlFormat + '\'' +
                ", serialNumberFmt='" + serialNumberFmt + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
