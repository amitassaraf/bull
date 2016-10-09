
# Bull
---------
Utility Framework for Android Applications.

Bull is a work in progress utility framework for Android that makes writing applications a bit easier and feel less like you reinvent the wheel each time.

Bull is built with simplicity in mind. 
Bull is aimed at Java 8 (Currently using Retrolambda).

Features
------------
--------------
 - Activity Switcher
 - Tasks
	 - Combined Task
	 - Network Task
	 - Repeating Task
	 - Repeating UI Task
 - String Utils
 - Common View
	 - findView
	 - setViewDrawListener
 - Common Utils
	 - notNull
	 - is
 - DialogUtils
	 - showMessagePopup
 - Conditioned
 - App State
 - View Utils (FontTextView and more)

Bull is **super** work in progress and will be updated frequently! If you would like to help with development, contact me!

Some examples:
-----------------------
---------------------------
**Activity Switcher**

    // Activity switcher
        ActivitySwitcher switcher = ActivitySwitcher
                .$chain(mContext)
                .delay(100)
                .intentFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                .transition(R.anim.fadein, R.anim.fadeout)
                .exitOnSwitch()
                .requireTrigger()
                .$switch(TestActivity.class);
        switcher.trigger();

 **Conditioned** is an object that returns between two values based on a condition
       
    Conditioned<Integer> menuColor = new Conditioned<>(R.color.colorPrimary,
                R.color.colorAccent, RandomUtils::yesno);

    // Get the value based on the condition
    System.out.println(StringUtils.format("This time we got color ", menuColor.get()));

**is** is a function that is used to check the logical existence of a variable  similar to python's "if var: # do stuff"

	if (CommonUtils.is(mSample)) {
        System.out.println("Woo hoo!");
    }

**Dialog Utils**
        
        DialogUtils.showMessagePopup(mContext, "Hello", "mate!");

**View drawn listener** // A listener for when a view is drawn
        
    CommonView.setViewDrawListener(mSample, view -> {
            int drawnHeight = view.getHeight();
            DialogUtils.showMessagePopup(mContext, "View Height",
            StringUtils.format("View height is ", drawnHeight));
        });

**Combined Task**

    new CombinedTask(this, metadata -> {
            metadata.putInt("test", 7); // This runs in a separate thread
        }, metadata -> {
            System.out.println(metadata.getInt("test", 0)); // This runs on the UI thread
        }).start();
**Repeating Task**

    new RepeatingTask(new TestActivity(), metadata -> {
            System.out.println("Forever repeating task");
        }, metadata -> true).start();

// Another Example

    Metadata repeatTimes = new Metadata();
    repeatTimes.putInt("repeat", 8);
    
    new RepeatingTask(new TestActivity(), metadata -> {
        System.out.println("This repeats 8 times!");
        metadata.putInt("repeat", metadata.getInt("repeat") - 1);
    }, metadata -> metadata.getInt("repeat") > 0).start(repeatTimes);

**Repeating UI Task**

    new RepeatingUITask(mContext, metadata -> {
            //DO UI THREAD THINGS
            metadata.putInt(repeat, metadata.getInt(repeat) - 1);
        }, metadata -> metadata.getInt(repeat) > 0).start(repeatTimes);

**AppState** is a simple enum that can be used to switch between debug and release states across the entire app
       
    AppState.currentState = AppState.DEBUG;

    if (AppState.isDebug()) {
        // Do debug things
        AppState.currentState = AppState.DEVELOPER;
    }

Also added some **common** ugly checks for the heck of it
       
    if (CommonUtils.notNull(mSample)) {
          mSample.setTop(View.DRAWING_CACHE_QUALITY_AUTO);
    }

Contact Me
----------
------------
LinkedIn: Amit Assaraf

Email: amit@helpi.me

If you have any suggestions or bugs feel free to email/message me!