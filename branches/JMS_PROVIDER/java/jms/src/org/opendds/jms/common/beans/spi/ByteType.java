/*
 * $Id$
 */

package org.opendds.jms.common.beans.spi;

import org.opendds.jms.common.beans.UnsupportedTypeException;

/**
 * @author  Steven Stallion
 * @version $Revision$
 */
public class ByteType implements Type<Byte> {

    public Class[] supportedTypes() {
        return new Class[] { byte.class, Byte.class };
    }

    public Byte defaultValue() {
        return 0;
    }

    public Byte valueOf(Object o) {
        if (o instanceof Boolean) {
            return ((Boolean) o) ? (byte) 1 : 0;

        } else if (o instanceof Number) {
            return ((Number) o).byteValue();

        } else if (o instanceof String) {
            return Byte.valueOf((String) o);
        }
        throw new UnsupportedTypeException(o);
    }
}
