package org.nd4j.parameterserver.updater;

import org.nd4j.linalg.api.ndarray.INDArray;

import java.util.Map;

/**
 * Created by agibsonccc on 12/1/16.
 */
public class TimeDelayedParameterUpdater implements ParameterServerUpdater {
    private long syncTime;
    private long lastSynced;


    /**
     * Returns the current status of this parameter server
     * updater
     *
     * @return
     */
    @Override
    public Map<String, Number> status() {
        return null;
    }

    /**
     * Serialize this updater as json
     *
     * @return
     */
    @Override
    public String toJson() {
        return null;
    }

    /**
     * Reset internal counters
     * such as number of updates accumulated.
     */
    @Override
    public void reset() {

    }

    /**
     * Returns true if
     * the updater has accumulated enough ndarrays to
     * replicate to the workers
     *
     * @return true if replication should happen,false otherwise
     */
    @Override
    public boolean shouldReplicate() {
        long now = System.currentTimeMillis();
        long diff = Math.abs(now - lastSynced);
        return diff > syncTime;
    }

    /**
     * Updates result
     * based on arr
     *
     * @param arr    the array to update
     * @param result the result ndarray to update
     */
    @Override
    public void update(INDArray arr, INDArray result) {

    }
}
