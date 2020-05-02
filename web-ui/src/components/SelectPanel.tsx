import React from 'react';

interface Props {
  expanded: boolean;
  children: any;
}

const TeamListPanel = function (props: Props) {
  const { expanded, children } = props;

  return (
    <div>
      {
        expanded ?
        children:
        <div></div>
      }
    </div>
  )
}

//ScenePanel.whyDidYouRender = true;

export default TeamListPanel;/*React.memo(ScenePanel, (prevProps, nextProps) => {
  if (prevProps.sceneExpanded === nextProps.sceneExpanded) {
    return true;
  }
  return false;
});*/
