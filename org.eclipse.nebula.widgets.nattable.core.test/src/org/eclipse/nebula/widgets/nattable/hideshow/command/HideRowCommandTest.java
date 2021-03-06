/*******************************************************************************
 * Copyright (c) 2013 Dirk Fauth and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dirk Fauth <dirk.fauth@gmail.com> - initial API and implementation
 *******************************************************************************/
package org.eclipse.nebula.widgets.nattable.hideshow.command;

import org.eclipse.nebula.widgets.nattable.command.ILayerCommand;
import org.eclipse.nebula.widgets.nattable.hideshow.RowHideShowLayer;
import org.eclipse.nebula.widgets.nattable.test.fixture.layer.DataLayerFixture;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HideRowCommandTest {

    private RowHideShowLayer rowHideShowLayer;

    @Before
    public void setup() {
        this.rowHideShowLayer = new RowHideShowLayer(new DataLayerFixture());
    }

    @Test
    public void testHideRowCommand() {
        int rowPosition = 2;
        ILayerCommand hideRowCommand = new MultiRowHideCommand(
                this.rowHideShowLayer, rowPosition);

        Assert.assertEquals(7, this.rowHideShowLayer.getRowCount());

        this.rowHideShowLayer.doCommand(hideRowCommand);

        Assert.assertEquals(6, this.rowHideShowLayer.getRowCount());

        Assert.assertEquals(0, this.rowHideShowLayer.getRowIndexByPosition(0));
        Assert.assertEquals(1, this.rowHideShowLayer.getRowIndexByPosition(1));
        Assert.assertEquals(3, this.rowHideShowLayer.getRowIndexByPosition(2));
        Assert.assertEquals(4, this.rowHideShowLayer.getRowIndexByPosition(3));
        Assert.assertEquals(5, this.rowHideShowLayer.getRowIndexByPosition(4));
        Assert.assertEquals(6, this.rowHideShowLayer.getRowIndexByPosition(5));
    }

}
