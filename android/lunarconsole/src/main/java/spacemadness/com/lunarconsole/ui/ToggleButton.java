//
//  ToggleButton.java
//
//  Lunar Unity Mobile Console
//  https://github.com/SpaceMadness/lunar-unity-console
//
//  Copyright 2016 Alex Lementuev, SpaceMadness.
//
//  Licensed under the Apache License, Version 2.0 (the "License");
//  you may not use this file except in compliance with the License.
//  You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.
//

package spacemadness.com.lunarconsole.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

public class ToggleButton extends Button
{
    private OnStateChangeListener stateChangeListener;
    private boolean on;

    public ToggleButton(Context context)
    {
        super(context);
        init();
    }

    public ToggleButton(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ToggleButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public ToggleButton(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    private void init()
    {
        setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setOn(!on);
            }
        });
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Listener notifications

    private void notifyStateChanged()
    {
        if (stateChangeListener != null)
        {
            stateChangeListener.onStateChanged(ToggleButton.this);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Getters/Setters

    public boolean isOn()
    {
        return on;
    }

    public void setOn(boolean flag)
    {
        if (on != flag)
        {
            on = flag;
            notifyStateChanged();
        }
    }

    public OnStateChangeListener getOnStateChangeListener()
    {
        return stateChangeListener;
    }

    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener)
    {
        this.stateChangeListener = onStateChangeListener;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Listener

    public interface OnStateChangeListener
    {
        void onStateChanged(ToggleButton button);
    }
}
