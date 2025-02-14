package tank.mods.microworld.entity.bacteriums.clostridium;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.animation.Keyframe;

public class ClostridiumAnimations {

public static final AnimationDefinition MOVE = AnimationDefinition.Builder.withLength(1.5f).looping()
.addAnimation("root",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 360f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("tail",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.125f, KeyframeAnimations.degreeVec(20f, 0f, 0.83f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(-24f, 0f, 2.22f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.4583433f, KeyframeAnimations.degreeVec(4f, -2.5f, 5f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.625f, KeyframeAnimations.degreeVec(10f, 8.1f, 6f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(3f, 2f, -6f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -3f, 6.62f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.1676667f, KeyframeAnimations.degreeVec(8f, -3f, 8f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.2916767f, KeyframeAnimations.degreeVec(-2.41f, 1f, 8.59f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.4167667f, KeyframeAnimations.degreeVec(4.04f, -0.65f, 9.44f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR))).build();
}
