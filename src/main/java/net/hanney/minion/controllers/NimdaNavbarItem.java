package net.hanney.minion.controllers;

/**
 * @author hanney
 */
public enum NimdaNavbarItem {
    SERVER_TYPES("Server Types", "/m/nimda/types"),
    OPERATING_SYSTEMS("Operating Systems", "/m/nimda/os"),
    DATA_CENTERS("Data Centers", "/m/nimda/dc");

    private NimdaNavbarItem(final String itemName, final String itemLink) {
        this.itemName = itemName;
        this.itemLink = itemLink;
    }

    private final String itemName, itemLink;

    public String getItemLink() {
        return itemLink;
    }

    public String getItemName() {
        return itemName;
    }
}
