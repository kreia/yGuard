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
package com.yworks.yguard.obf;

/**
 * Interface to a list of method and field names and descriptors -- used for checking
 * if a name/descriptor is in the public/protected lists of the super-class/interface
 * hierarchy.
 *
 * @author      Mark Welsh
 */
public interface NameListUp
{
    /** Get output method name from list, or null if no mapping exists. */
    public String getMethodOutNameUp(String name, String descriptor) throws ClassNotFoundException;
    /** Get obfuscated method name from list, or null if no mapping exists. */
    public String getMethodObfNameUp(String name, String descriptor) throws ClassNotFoundException;
    /** Get output field name from list, or null if no mapping exists. */
    public String getFieldOutNameUp(String name) throws ClassNotFoundException;
    /** Get obfuscated field name from list, or null if no mapping exists. */
    public String getFieldObfNameUp(String name) throws ClassNotFoundException;
}

