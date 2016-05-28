package com.nkspaun.TwinSunshine.loader;

import java.util.List;

public class UnityImageStore {
    public static String getImageUrlSlide0 = "https://www.unseen64.net/wp-content/uploads/2008/04/zelda-gaiden-link-mask.jpg";
    public static String getImageUrlSlide1 = "http://vignette3.wikia.nocookie.net/zelda/images/9/92/Deku.png/revision/latest?cb=20150207000240";
    public static String getImageUrlSlide2 = "http://vignette2.wikia.nocookie.net/zelda/images/8/83/Goron.png/revision/latest?cb=20150207000716";
    public static String getImageUrlSlide3 = "http://vignette2.wikia.nocookie.net/zelda/images/d/d5/Zora.png/revision/latest?cb=20150207000510";
    public static String getImageUrlSlide4 = "http://vignette2.wikia.nocookie.net/zelda/images/4/4b/Dietyoffierce.png/revision/latest?cb=20150207001008";
    public static String getImageUrlSlide5 = "http://img14.deviantart.net/c34e/i/2003/37/e/d/majora__s_mask.jpg";

    public static void init(List<String> imageUrls) {
        if (imageUrls != null && imageUrls.size() == 6) {
            UnityImageStore.getImageUrlSlide0 = imageUrls.get(0);
            UnityImageStore.getImageUrlSlide1 = imageUrls.get(1);
            UnityImageStore.getImageUrlSlide2 = imageUrls.get(2);
            UnityImageStore.getImageUrlSlide3 = imageUrls.get(3);
            UnityImageStore.getImageUrlSlide4 = imageUrls.get(4);
            UnityImageStore.getImageUrlSlide5 = imageUrls.get(5);
        }
    }
}
