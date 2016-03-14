/*
 * Copyright 2015 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.plaidapp.data.api.hackernews;

import java.util.List;

import io.plaidapp.data.PlaidItemSorting;
import io.plaidapp.data.api.designernews.model.Story;
import io.plaidapp.data.api.hackernews.model.TopStory;

/**
 * Utility class for applying weights to a group of {@link Story}s for sorting. Weighs stories
 * relative to the most upvoted & commented stories in the group.
 */
public class TopStoryWeigher implements PlaidItemSorting.PlaidItemGroupWeigher<TopStory> {

    @Override
    public void weigh(List<TopStory> stories) {
        float maxScore = 0f;
        for (TopStory story : stories) {
            maxScore = Math.max(maxScore, story.score);
        }
        for (TopStory story : stories) {
            float weight = 1f - ((float) story.score / maxScore);
            story.weight = story.page + weight;
        }
    }

}
