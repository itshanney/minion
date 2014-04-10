package net.hanney.minion.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

/**
 * Abstract view Controller that contains common, reusable logic for all Controllers
 *
 * @author justin.hanney
 */
public abstract class AbstractController {

    @ModelAttribute(value = "navbarItems")
    public List<NavbarItem> getNavbarItems() {
        return Arrays.asList(NavbarItem.values());
    }

    @ModelAttribute(value = "selectedNavbarItem")
    public abstract NavbarItem getSelectedNavbarItem();

}
