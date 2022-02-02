package edu.byu.cs.tweeter.client.model.service.backgroundTask;

import android.os.Bundle;
import android.os.Handler;

import edu.byu.cs.tweeter.model.domain.AuthToken;
import edu.byu.cs.tweeter.model.domain.User;

/**
 * Background task that queries how many followers a user has.
 */
public class GetFollowersCountTask extends GetCountTask {
//    private static final String LOG_TAG = "GetFollowersCountTask";

    public GetFollowersCountTask(AuthToken authToken, User targetUser, Handler messageHandler) {
        super(messageHandler, authToken, targetUser);
    }

    @Override
    protected void runTask() {
        //  TODO Milestone 3
    }

    @Override
    protected void loadMessageBundle(Bundle msgBundle) {
        //  TODO Milestone 3 - Add legit logic for count
        int count = 20;
        msgBundle.putInt(COUNT_KEY, count);
    }
}
