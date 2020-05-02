import { withStyles } from '@material-ui/core/styles';
import Tabs from '@material-ui/core/Tabs';

const tabHeight = '32px';

const SelectTabs = withStyles({
  root: {
    minHeight: tabHeight,
    height: tabHeight
  }
})(Tabs);

export default SelectTabs;
