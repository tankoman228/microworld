package tank.mods.microworld.entity.ciliates.shoe;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class ShoeAnimations {


	public static final AnimationDefinition ANIMATION = AnimationDefinition.Builder.withLength(8f).looping()
	.addAnimation("bone2",
		new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(2f, KeyframeAnimations.posVec(0.4f, 0f, -0.5f),
				AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(6f, KeyframeAnimations.posVec(0.4f, 0f, -0.5f),
				AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(8f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("bone3",
		new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(2f, KeyframeAnimations.posVec(-0.3f, 0f, -0.4f),
				AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(6f, KeyframeAnimations.posVec(-0.3f, 0f, -0.4f),
				AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(8f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("bone4",
		new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(2f, KeyframeAnimations.posVec(-0.3f, 0f, 0.1f),
				AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(6f, KeyframeAnimations.posVec(-0.3f, 0f, 0.1f),
				AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(8f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("bone5",
		new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(2f, KeyframeAnimations.posVec(0.4f, 0f, 0.2f),
				AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(6f, KeyframeAnimations.posVec(0.4f, 0f, 0.2f),
				AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(8f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("organs",
		new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.LINEAR),
			new Keyframe(8f, KeyframeAnimations.degreeVec(0f, 0f, 360f),
				AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("body",
		new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.LINEAR),
			new Keyframe(8f, KeyframeAnimations.degreeVec(0f, 0f, 360f),
				AnimationChannel.Interpolations.LINEAR))).build();
}
