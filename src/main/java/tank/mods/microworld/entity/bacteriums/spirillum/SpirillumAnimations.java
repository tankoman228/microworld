package tank.mods.microworld.entity.bacteriums.spirillum;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.animation.Keyframe;

public class SpirillumAnimations {

public static final AnimationDefinition LOOP = AnimationDefinition.Builder.withLength(2.75f).looping()
.addAnimation("root",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2.75f, KeyframeAnimations.degreeVec(0f, 0f, -360f),
			AnimationChannel.Interpolations.LINEAR))).build();
}
