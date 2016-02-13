/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

/**
 *
 * @author radiancekfx
 */
public class StopWatch
{
    private boolean running;    // is the watch keeping track of time
    private long start;         // starting millisecond count
    private long accum;         // total milliseconds

    public StopWatch()
    // post: returns a stopped watch
    {
        running = false;
        start = 0;
        accum = 0;
    }

    public void start()
    // post: watch is stopped
    // pre: starts watch, begins accumulating time
    {
        if(running == false)
        { running = true;
          start = System.currentTimeMillis();
        }
    }

    public void stop()
    // pre: watch is running
    // post: stops watch, and accumulates time
    {
        if(running == true)
        { running = false;
          accum += (System.currentTimeMillis()-start);
        }
    }

    public double read()
    // post: returns the accumulated time on the watch      seconds
    {
        if (running)
        {
            return (double)(accum+(System.currentTimeMillis()-start))/1000.0;
        } else {
            return (double)accum/1000.0;
        }
    }

    public double readX()
    // post: returns the accumulated time on the watch      milliseconds
    {
        if (running)
        {
            return (double)(accum+(System.currentTimeMillis()-start));
        } else {
            return (double)accum;
        }
    }

    public boolean askRunning()
    // post: returns true if Watch is running
    {
    	return running;
    }	

    public void reset()
    // post: stops running watch and clears the accumulated time.
    {
        running = false;
        accum = 0;
    }

    public String toString()
    // post: returns a string representation of the watch
    {
        return "<Watch: "+read()+" seconds>";
    }
}