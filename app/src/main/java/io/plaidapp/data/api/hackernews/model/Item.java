package io.plaidapp.data.api.hackernews.model;

import android.os.Parcel;
import android.os.Parcelable;

import io.plaidapp.data.PlaidItem;


/**
 * Created by Jonas Rottmann on 13/03/16.
 */
public class Item extends PlaidItem implements Parcelable {

    public static final String TYPE_STORY = "story";
    public static final String TYPE_COMMENT = "comment";

    public final String by;
    public final Integer descendants;
    public final Integer score;
    public final String text;
    public final Long time;
    public final String type;

    public Item(long id, String by, Integer descendants, Integer score, String text, Long time, String title, String type, String url) {
        super(id, title, url);
        this.by = by;
        this.descendants = descendants;
        this.score = score;
        this.text = text;
        this.time = time;
        this.type = type;
    }


    protected Item(Parcel in) {
        super(in.readLong(), in.readString(), in.readString());
        by = in.readString();
        descendants = in.readInt();
        score = in.readInt();
        text = in.readString();
        time = in.readLong();
        type = in.readString();
    }


    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }


        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(title);
        dest.writeString(url);
        dest.writeString(by);
        dest.writeInt(descendants);
        dest.writeInt(score);
        dest.writeString(text);
        dest.writeLong(time);
        dest.writeString(type);
    }

    public boolean isStory() {
        return TYPE_STORY.equals(type);
    }

    public boolean isComment() {
        return TYPE_COMMENT.equals(type);
    }
}
