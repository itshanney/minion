package net.hanney.minion.controllers;

/**
 * Enum that contains all of the navigation sub-elements in the Network section
 *
 * @author justin.hanney
 */
public enum NetworkNavbarItem {

    SSL_CERTIFICATES("SSL Certificates", "/m/network/certs");

    private NetworkNavbarItem(final String itemName, final String itemLink) {
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
