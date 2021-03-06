package com.example.prasergram.fragments;

import android.util.Log;

import com.example.prasergram.Post;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ProfileFragment extends PostsFragment{
    @Override
    protected void querypost() {
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        query.setLimit(20);
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
        query.addAscendingOrder(Post.KEY_CREATEDAT);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> objects, ParseException e) {
                if(e != null){
                    Log.e(TAG,"issue with post",e);
                    return;
                }
                for(Post post : objects){
                    Log.i(TAG, "Post: " + post.getDescription() + " Username: " + post.getUser().getUsername());
                    //Log.i(TAG, "Post: " + post.getUser().toString());
                }
                allPost.addAll(objects);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
