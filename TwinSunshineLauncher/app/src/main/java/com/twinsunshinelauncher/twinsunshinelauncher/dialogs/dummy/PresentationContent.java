package com.twinsunshinelauncher.twinsunshinelauncher.dialogs.dummy;

import com.twinsunshinelauncher.twinsunshinelauncher.models.Presentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PresentationContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Presentation> ITEMS = new ArrayList<>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Presentation> ITEM_MAP = new HashMap<>();

    private static final int COUNT = 3;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createPresentation(i));
        }
    }

    private static void addItem(Presentation item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getId(), item);
    }

    private static Presentation createPresentation(int position) {
        List<Presentation> presentations = Presentation.getTestPresentations();
        return presentations.get(position % presentations.size());
    }
}

