![image](https://user-images.githubusercontent.com/59634395/172030275-4300cfe7-7ed6-495c-8620-8c5f26dc33aa.png)

# Introduction and Potential Applications

Welcome to this multifunctional synthesizer written entirely in Java! Audio Synthesizers appear in the world of music production and more, as they can be used for visualization of the Fourier Transform, modeling sounds from real-world applications, and even automation tools for speech recognition programs. This application provides an intuitive way of visualizing waveforms using amplification and attenuation of four different oscillators consisting of sine, square, saw, and triangle waveforms!


# Features of the Synthesizer 

User-friendly interface 
Frequency Adjuster
Amplitude Adjuster
Signal Visualization graph in time domain
Signal Visualization graph in frequency domain (Fourier Transform)
Wave Selection Drop Down (Sine, Square, Triangle, and Saw)
Mute Capability 
Key Visualizer


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
Select keys from the following to play a sound
Q, W, E, R, T, Y, U, I, O, P, \[, and \]
You can hold a note while changing your oscillators (wave-form, frequency, and amplitude).
To change Wave type:
Select the drop-down in the box of choice
Click on your desired wave-form
To change Frequency / Pitch:
While clicking the pitch box, drag your mouse up or down to your desired value.
To change Amplitude:
While clicking the amplitude box, drag your mouse up or down to your desired value.
To mute a signal:
Click the mute button located inside the signal box of your choice. 
To unmute a signal:
Increase the amplitude of the signal of choice to unmute. 



Enjoy!
