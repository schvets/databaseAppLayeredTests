package tools.controls.contracts;

/**
 * Determines the main functionality for the Link control.
 */
public interface Link {
    
    /**
     * Click this element. There are some preconditions
     * for an element to be clicked. The element must be visible
     * and it must have a height and width greater then 0.
     */
    void click();
    
    /**
     * Get the visible (i.e. not hidden by CSS) innerText of this element,
     * including sub-elements, without any leading or trailing whitespace.
     *
     * @return The innerText of this element.
     */
    String getText();
    
    /**
     * Get the value of a the "href" attribute of the element.
     *
     * @return String value of the "href" attribute. if the base url is
     * "http://HelloWorld.com" and the html-element has "href="/?page=2"",
     * the "http://HelloWorld.com/?page=2" will be returned.
     */
    String getHref();
    
    
    /**
     * Get the value of a the "id" attribute of the element.
     *
     * @return String value of the "id" attribute.
     */
    String getID();


    boolean isVisible();
}
