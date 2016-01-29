
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
 - Date Utils
 - Math Utils
 - Animation Utils
 - View Utils (FontTextView and more)

Bull is **super** work in progress and will be updated frequently! If you would like to help with development, contact me!

Some examples:
-----------------------
---------------------------
Activity Switcher

    ActivitySwitcher switcher = ActivitySwitcher.$chain(this)
	.delay(100) // Switch Delay
	.intentFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK) 
	.transition(R.anim.fadein, R.anim.fadeout)
	.exitOnSwitch() // Finish current activity on switch
	.requireTrigger() // Require triggering
	.$switch(TargetActivity.class);
    
    switcher.trigger(); // Trigger switch

Combined Task

    new CombinedTask(this, metadata -> {
            metadata.putInt("test", 7); // This runs in a separate thread
        }, metadata -> {
            System.out.println(metadata.getInt("test", 0)); // This runs on the UI thread
        }).start();
Repeating Task

    new RepeatingTask(new TestActivity(), metadata -> {
            System.out.println("Forever repeating task");
        }, metadata -> true).start();

        Metadata repeatTimes = new Metadata();
        repeatTimes.putInt("repeat", 8);
        new RepeatingTask(new TestActivity(), metadata -> {
            System.out.println("This repeats 8 times!");
            metadata.putInt("repeat", metadata.getInt("repeat") - 1);
        }, metadata -> metadata.getInt("repeat") > 0).start(repeatTimes);

Contact Me
----------
------------
LinkedIn: Amit Assaraf

Email: amit@helpi.me

If you have any suggestions or bugs feel free to email/message me!