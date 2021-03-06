/**
 * YGuard -- an obfuscation library for Java(TM) classfiles.
 *
 * Original Copyright (c) 1999 Mark Welsh (markw@retrologic.com)
 * Modifications Copyright (c) 2002 yWorks GmbH (yguard@yworks.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * The author may be contacted at yguard@yworks.com 
 *
 * Java and all Java-based marks are trademarks or registered 
 * trademarks of Sun Microsystems, Inc. in the U.S. and other countries.
 */
package com.yworks.yguard.obf.classfile;

import java.io.*;
import java.util.*;

/**
 * Representation of a 'nameandtype' entry in the ConstantPool.
 *
 * @author      Mark Welsh
 */
public class NameAndTypeCpInfo extends CpInfo implements Cloneable
{
    // Constants -------------------------------------------------------------


    // Fields ----------------------------------------------------------------
    private int u2nameIndex;
    private int u2descriptorIndex;


    // Class Methods ---------------------------------------------------------


    // Instance Methods ------------------------------------------------------
    protected NameAndTypeCpInfo()
    {
        super(CONSTANT_NameAndType);
    }

    /** Clone the entry. */
    public Object clone()
    {
        NameAndTypeCpInfo cloneInfo = new NameAndTypeCpInfo();
        cloneInfo.u2nameIndex = this.u2nameIndex;
        cloneInfo.u2descriptorIndex = this.u2descriptorIndex;
        cloneInfo.resetRefCount();
        return cloneInfo;
    }

    /** Return the name index. */
    protected int getNameIndex() {return u2nameIndex;}

    /** Set the name index. */
    protected void setNameIndex(int index) {u2nameIndex = index;}

    /** Return the descriptor index. */
    protected int getDescriptorIndex() {return u2descriptorIndex;}

    /** Set the descriptor index. */
    protected void setDescriptorIndex(int index) {u2descriptorIndex = index;}

    /** Check for Utf8 references to constant pool and mark them. */
    protected void markUtf8Refs(ConstantPool pool) 
    {
        pool.incRefCount(u2nameIndex);
        pool.incRefCount(u2descriptorIndex);
    }

    /** Read the 'info' data following the u1tag byte. */
    protected void readInfo(DataInput din) throws java.io.IOException
    {
        u2nameIndex = din.readUnsignedShort();
        u2descriptorIndex = din.readUnsignedShort();
    }

    /** Write the 'info' data following the u1tag byte. */
    protected void writeInfo(DataOutput dout) throws java.io.IOException
    {
        dout.writeShort(u2nameIndex);
        dout.writeShort(u2descriptorIndex);
    }
}
