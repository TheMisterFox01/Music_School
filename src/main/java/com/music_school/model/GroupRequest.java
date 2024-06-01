package com.music_school.model;

import org.jetbrains.annotations.NotNull;

public record GroupRequest(
        @NotNull
        int group_id,
        @NotNull
        int teacher_id
) {
}
