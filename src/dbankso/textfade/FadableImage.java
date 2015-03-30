package dbankso.textfade;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class FadableImage extends Image {

    public FadableImage(int width, int height) throws SlickException {
        super(width, height);
    }
    
    public FadableImage(Image image) {
        super(image);
    }
    
    @Override
    public Image getSubImage(int x,int y,int width,int height) {
        return new FadableImage(super.getSubImage(x, y, width, height));
    }
    
    public void drawEmbeddedFaded(float x,float y,float width,float height, Color color, float fadePercentWidth) {
        init();
        
        //if percent width is set to an invalid amount, default it to 1.
        if(fadePercentWidth < 0.0f || fadePercentWidth > 1.0f)
            fadePercentWidth = 1.0f;

        if (corners == null) {
            GL.glTexCoord2f(textureOffsetX, textureOffsetY);
            GL.glVertex3f(x, y, 0);
            GL.glTexCoord2f(textureOffsetX, textureOffsetY + textureHeight);
            GL.glVertex3f(x, y + height, 0);
            
            //set the color of x2 and y2 of the quad to 0 alpha
            GL.glColor4f(color.r, color.g, color.b, 0.0f);
            GL.glTexCoord2f(textureOffsetX + textureWidth*fadePercentWidth, textureOffsetY
                    + textureHeight);
            GL.glVertex3f(x + width*fadePercentWidth, y + height, 0);
            GL.glTexCoord2f(textureOffsetX + textureWidth*fadePercentWidth, textureOffsetY);
            GL.glVertex3f(x + width*fadePercentWidth, y, 0);
            //reset the color
            GL.glColor4f(color.r, color.g, color.b, color.a);
        } else {
            corners[TOP_LEFT].bind();
            GL.glTexCoord2f(textureOffsetX, textureOffsetY);
            GL.glVertex3f(x, y, 0);
            corners[BOTTOM_LEFT].bind();
            GL.glTexCoord2f(textureOffsetX, textureOffsetY + textureHeight);
            GL.glVertex3f(x, y + height, 0);
            //set the color of x2 and y2 of the quad to 0 alpha
            GL.glColor4f(color.r, color.g, color.b, 0.0f);
            //corners[BOTTOM_RIGHT].bind();
            GL.glTexCoord2f(textureOffsetX + textureWidth*fadePercentWidth, textureOffsetY
                    + textureHeight);
            GL.glVertex3f(x + width*fadePercentWidth, y + height, 0);
            //corners[TOP_RIGHT].bind();
            GL.glTexCoord2f(textureOffsetX + textureWidth*fadePercentWidth, textureOffsetY);
            GL.glVertex3f(x + width*fadePercentWidth, y, 0);
            //reset the color
            GL.glColor4f(color.r, color.g, color.b, color.a);
        }
    }

}
