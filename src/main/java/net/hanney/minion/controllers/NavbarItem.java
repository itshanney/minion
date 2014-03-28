package net.hanney.minion.controllers;

/**
 * Enum that contains all of the Navbar elements for navigation
 *
 * @author justin.hanney
 */
public enum NavbarItem {
    SERVERS("Servers", "/m/servers"),
    NIMDA("Nimda", "/m/nimda");

    private NavbarItem(final String itemName, final String itemLink) {
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
