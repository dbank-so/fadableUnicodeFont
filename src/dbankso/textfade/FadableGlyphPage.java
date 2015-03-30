package dbankso.textfade;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.GlyphPage;

public class FadableGlyphPage extends GlyphPage {

    public FadableGlyphPage(UnicodeFont unicodeFont, int pageWidth, int pageHeight) throws SlickException {
        super(unicodeFont, pageWidth, pageHeight, new FadableImage(pageWidth, pageHeight));
    }

}
