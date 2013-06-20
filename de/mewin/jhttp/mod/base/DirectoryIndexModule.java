package de.mewin.jhttp.mod.base;

import de.mewin.jhttp.event.EventHandler;
import de.mewin.jhttp.event.Listener;
import de.mewin.jhttp.event.RequestDocumentEvent;
import de.mewin.jhttp.mod.Module;
import java.io.File;
import java.io.FileFilter;

/*
 * Copyright (C) 2013 mewin<mewin001@hotmail.de>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 *
 * @author mewin<mewin001@hotmail.de>
 */
public class DirectoryIndexModule extends Module implements Listener, FileFilter
{
    
    @Override
    protected void onEnable()
    {
        getServer().getEventManager().registerEvents(this);
    }
    
    @EventHandler
    public void onRequestDocument(RequestDocumentEvent e)
    {
        if (e.getFile().isDirectory())
        {
            for (File f : e.getFile().listFiles(this))
            {
                e.setFile(f);
                return;
            }
        }
    }

    @Override
    public boolean accept(File file)
    {
        return file.isFile() && file.getName().toLowerCase().equals("index.html");
    }
}