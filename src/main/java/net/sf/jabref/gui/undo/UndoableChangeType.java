/*  Copyright (C) 2003-2011 JabRef contributors.
    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
*/
package net.sf.jabref.gui.undo;

import javax.swing.undo.AbstractUndoableEdit;

import net.sf.jabref.model.entry.BibEntry;

/**
 * This class represents the change of type for an entry.
 */
public class UndoableChangeType extends AbstractUndoableEdit {

    private final String oldType;
    private final String newType;
    private final BibEntry be;


    public UndoableChangeType(BibEntry be, String oldType, String newType) {
        this.oldType = oldType;
        this.newType = newType;
        this.be = be;
    }

    @Override
    public String getUndoPresentationName() {
        return "Undo: change type";
    }

    @Override
    public String getRedoPresentationName() {
        return "Redo: change type";
    }

    @Override
    public void undo() {
        super.undo();
        be.setType(oldType);
    }

    @Override
    public void redo() {
        super.redo();
        be.setType(newType);
    }

}
