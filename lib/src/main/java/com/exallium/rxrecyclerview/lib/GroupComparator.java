/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Alex Hart
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.exallium.rxrecyclerview.lib;

import com.exallium.rxrecyclerview.lib.event.Event;

import java.util.Comparator;

/**
 * Allows for easy Grouping and Sorting of Events and their Internal Data
 * @param <K> The Event Key
 * @param <V> The Event Value
 */
public interface GroupComparator<K, V> extends Comparator<Event<K, V>> {
    /**
     * Given an Event in a group, get the group key associated with it.
     * @param event The event we are analyzing
     * @return A string representing the group key.
     */
    String getGroupKey(Event<K, V> event);

    /**
     * Generate an empty event. Can return null if you don't plan to support an empty view.
     * @param eventType The type of event to generate
     * @return a new instance of event or null
     */
    Event<K, V> getEmptyEvent(Event.TYPE eventType);
}
