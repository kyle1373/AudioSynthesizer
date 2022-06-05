![image](https://user-images.githubusercontent.com/59634395/172030285-ea81e00c-8585-4cc1-bdee-a7fe8729bf4d.png)

# Introduction and Potential Applications

Welcome to our multifunctional synthesizer written entirely in Java! This was a project originally done by Kyle Wade, Delvin Bajoua, Jerry Qiao, and Youssef Georgy. After mathematically learning about Fourier Transforms one class, we thought it would be interesting to create a visualization of a synthesizer to experience Fourier Transforms in real time through audio and visual representation. Audio Synthesizers appear in the world of music production and more, as they can be used for visualization of the Fourier Transform, modeling sounds from real-world applications, and even automation tools for speech recognition programs. This application provides an intuitive way of visualizing waveforms using amplification and attenuation of four different oscillators consisting of sine, square, saw, and triangle waveforms! Read this write up to find a demo of the app and a tutorial on how to set it up.


# Features of the Synthesizer 

User-friendly interface  <br />
Frequency Adjuster <br />
Amplitude Adjuster <br />
Signal Visualization graph in time domain <br />
Signal Visualization graph in frequency domain (Fourier Transform) <br />
Wave Selection Drop Down (Sine, Square, Triangle, and Saw) <br />
Mute Capability  <br />
Key Visualizer <br />


# Applied Concepts of Synthesizer to Class Concepts

If we add multiple waves together, then the waves are added together in the time domain. However, while it is easy to add waves in the time domain, it is nearly impossible to deconstruct the wave through just its time domain graph. However, the Fourier Transform solves this issue through taking a signal in the time domain and transforming into its frequency domain counterpart. This is so when multiple waves are combined, it is still possible to extract the waves through their Fourier coefficient peaks in their Fourier Series. Higher frequencies result in higher Fourier coefficients, and lower frequencies result in lower Fourier coefficients. The Fourier Transform graph featured in this audio synthesizer is the result of a function of each oscillator’s amplitude and pitch.
 

# Demo
https://www.youtube.com/watch?v=Y9EVM5ODyVc 


# How to Run
DOWNLOAD THE SYNTHESIZER FILE HERE: https://www.dropbox.com/sh/idttyvt6gaukmj4/AABYpMo82biC7avYnSQZpHdXa?dl=0

Make sure to extract the jar files to your Desktop and have Java installed on your computer!
If you are using Windows, run the ECE45Windows.jar file.
If you are using MacOS, run the ECE45MacOS.jar file. 
On MacOS if you get an unidentified developer error, simply click ok. Next highlight the Jar File then click open from the dropdown, it will now open successfully.

You can also build the project yourself by cloning the repo and constructing a .jar file, but it is highly advised to just simply download the .jar files above. 


# Usage Instructions
**To play a sound** <br />
Select Q, W, E, R, T, Y, U, I, O, P, \[, or \] to play different requencies. <br />
You can hold a note while changing your oscillators (wave-form, frequency, and amplitude). <br />
<br />
 <br />
**To change Wave type:** <br />
Select the drop-down in the box of choice. <br />
Click on your desired wave-form. <br /> 
<br />
**To change Frequency / Pitch:** <br />
While clicking the pitch box, drag your mouse up or down to your desired value. <br />
 <br />
**To change Amplitude:** <br />
While clicking the amplitude box, drag your mouse up or down to your desired value. <br />
 <br />
**To mute a signal:** <br />
Click the mute button located inside the signal box of your choice.  <br />
 <br />
**To unmute a signal:** <br />
Increase the amplitude of the signal of choice to unmute.  <br />
 <br />
# Sources and Libraries used
Thank you to “G223 Productions” for helping with the project framework as well as libraries and functionality:<br />
https://www.youtube.com/channel/UCjGTOnMHKk73DC9BTsf2c9Q <br />
<br />
Thank you to LWJGl Library used within the project:<br />
Specifications: Zip bundle version 3.1.6, Contents: OpenAL<br />
https://www.lwjgl.org/customize<br />
<br />
Helpful Conceptual Review:<br />
https://learningsynths.ableton.com/en/playground<br />
<br />
Sound Synthesis Theory Conceptual Article:<br />
https://en.wikibooks.org/wiki/Sound_Synthesis_Theory/Introduction<br />
<br />
 <br />
Enjoy!
