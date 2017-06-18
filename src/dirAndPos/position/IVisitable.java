package dirAndPos.position;

import dirAndPos.AbstractPosition;

/**
 * Created by Maxime on 13/12/2015.
 */
public interface IVisitable {

    // Not the real "Visitor" design pattern

    AbstractPosition visit(AbstractPosition init);
}
