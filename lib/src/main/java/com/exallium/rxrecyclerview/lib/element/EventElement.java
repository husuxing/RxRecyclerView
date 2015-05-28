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

package com.exallium.rxrecyclerview.lib.element;

import com.exallium.rxrecyclerview.lib.GroupComparator;
import com.exallium.rxrecyclerview.lib.event.Event;

public class EventElement<K, V> implements Element<Event<K, V>> {

    private final Event<K, V> event;
    private final GroupComparator<Event<K, V>> eventGroupComparator;

    public EventElement(Event<K, V> event, GroupComparator<Event<K, V>> groupComparator) {
        this.event = event;
        this.eventGroupComparator = groupComparator;
    }

    @Override
    public String getGroup() {
        return eventGroupComparator.getGroupKey(event);
    }

    @Override
    public int getViewType() {
        return 0;
    }

    @Override
    public Event<K, V> getData() {
        return event;
    }


    @Override
    public int compareTo(Element<Event<K, V>> another) {
        int groupComparison = getGroup().compareTo(another.getGroup());
        if (groupComparison != 0) {
            return groupComparison;
        }
        return eventGroupComparator.compare(getData(), another.getData());
    }
}
