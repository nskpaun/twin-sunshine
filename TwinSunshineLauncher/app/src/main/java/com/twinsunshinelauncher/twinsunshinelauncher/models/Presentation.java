package com.twinsunshinelauncher.twinsunshinelauncher.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nspaun on 5/27/16.
 */
public class Presentation {
    private String id;
    private String name;
    private ArrayList<String> imageUrls;

    public Presentation(String id, String name, ArrayList<String> imageUrls) {
        this.id = id;
        this.name = name;
        this.imageUrls = imageUrls;
    }

    public Presentation(String id) {
        this.id = id;
        imageUrls = new ArrayList<>();
        imageUrls.add("");
        imageUrls.add("");
        imageUrls.add("");
        imageUrls.add("");
        imageUrls.add("");
        imageUrls.add("");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setImageUrl(int index, String url) {
        imageUrls.set(index, url);
    }

    public ArrayList<String> getImageUrls() {
        return imageUrls;
    }

    public String getName() {
        return name;
    }

    public static List<Presentation> getTestPresentations() {
        List<Presentation> presentations = new ArrayList<>();

        ArrayList<String> images = new ArrayList<>();
        images.add("http://vignette2.wikia.nocookie.net/zelda/images/d/d5/Zora.png/revision/latest?cb=20150207000510");
        images.add("http://vignette2.wikia.nocookie.net/zelda/images/4/4b/Dietyoffierce.png/revision/latest?cb=20150207001008");
        images.add("http://img14.deviantart.net/c34e/i/2003/37/e/d/majora__s_mask.jpg");
        images.add("https://www.unseen64.net/wp-content/uploads/2008/04/zelda-gaiden-link-mask.jpg");
        images.add("http://vignette3.wikia.nocookie.net/zelda/images/9/92/Deku.png/revision/latest?cb=20150207000240");
        images.add("http://vignette2.wikia.nocookie.net/zelda/images/8/83/Goron.png/revision/latest?cb=20150207000716");

        presentations.add(new Presentation("1", "Zelda", images));

        images = new ArrayList<>();
        images.add("http://wallpaperswa.com/thumbnails/detail/20130112/suit%20men%20arnold%20schwarzenegger%20actors%20politician%202000x1360%20wallpaper_wallpaperswa.com_40.jpg");
        images.add("http://1u88jj3r4db2x4txp44yqfj1.wpengine.netdna-cdn.com/wp-content/uploads/2015/08/donald-trump-hated-politician-930x619.jpg");
        images.add("http://static3.businessinsider.com/image/5419d9a969bedd645047c0d1/joe-biden-calls-singapore-politician-the-wisest-man-in-the-orient.jpg");
        images.add("http://www.oxcoll.com/tew/tests/Who-is-who/Hillary-Clinton.jpg");
        images.add("http://www.therealbest.com/img/items/big/662/Barack-Hussein-Obama_A-Fantastic-Politician_1008.jpg");
        images.add("http://www.environmental-watch.com/wp-content/uploads/2013/12/shutterstock_3975115.jpg");

        presentations.add(new Presentation("2", "Politicians", images));

        images = new ArrayList<>();
        images.add("http://image.slidesharecdn.com/slidesharesethgodin-140712204335-phpapp01/95/fix-your-really-bad-powerpoint-by-slidecomet-based-on-an-ebook-by-thisissethsblog-1-638.jpg?cb=1445496226");
        images.add("http://image.slidesharecdn.com/slidesharesethgodin-140712204335-phpapp01/95/fix-your-really-bad-powerpoint-by-slidecomet-based-on-an-ebook-by-thisissethsblog-2-1024.jpg?cb=1445496226");
        images.add("http://image.slidesharecdn.com/slidesharesethgodin-140712204335-phpapp01/95/fix-your-really-bad-powerpoint-by-slidecomet-based-on-an-ebook-by-thisissethsblog-3-1024.jpg?cb=1445496226");
        images.add("http://image.slidesharecdn.com/slidesharesethgodin-140712204335-phpapp01/95/fix-your-really-bad-powerpoint-by-slidecomet-based-on-an-ebook-by-thisissethsblog-4-1024.jpg?cb=1445496226");
        images.add("http://www.sethgodin.com/freeprize/reallybad-1.pdf");
        images.add("http://image.slidesharecdn.com/slidesharesethgodin-140712204335-phpapp01/95/fix-your-really-bad-powerpoint-by-slidecomet-based-on-an-ebook-by-thisissethsblog-6-1024.jpg?cb=1445496226");

        presentations.add(new Presentation("3", "Bad Power Point", images));

        return presentations;
    }
}
