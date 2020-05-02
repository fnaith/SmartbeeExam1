import { withStyles } from '@material-ui/core/styles';
import Tab from '@material-ui/core/Tab';

const tabHeight = '32px';

const SelectTab = withStyles({
  root: {
    minWidth: 90,
    minHeight: tabHeight,
    height: tabHeight,
    fontSize: '1.125rem',
    padding: 8
  }
})(Tab);

export default SelectTab;
