/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.sun.javafx.sg.prism;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.Ellipse2D;
import com.sun.javafx.geom.Shape;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.sg.PGCircle;
import com.sun.prism.Graphics;
import com.sun.prism.shape.ShapeRep;

/**
 *
 */
public class NGCircle extends NGShape implements PGCircle {

    private Ellipse2D ellipse = new Ellipse2D();

    @Override public void updateCircle(float cx, float cy, float r) {
        ellipse.x = cx - r;
        ellipse.y = cy - r;
        ellipse.width = r * 2f;
        ellipse.height = ellipse.width;
        geometryChanged();
    }

    @Override
    public Shape getShape() {
        return ellipse;
    }

    @Override
    protected ShapeRep createShapeRep(Graphics g, boolean needs3D) {
        return g.getResourceFactory().createEllipseRep(needs3D);
    }
}